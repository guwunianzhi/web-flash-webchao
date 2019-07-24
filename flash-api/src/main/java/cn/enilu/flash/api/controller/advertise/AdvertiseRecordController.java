package cn.enilu.flash.api.controller.advertise;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.advertise.AdvertiseRecord;
import cn.enilu.flash.bean.entity.system.User;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.service.advertise.AdvertiseRecordService;
import cn.enilu.flash.service.system.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/advertise")
@Slf4j
public class AdvertiseRecordController extends BaseController {

    @Autowired
    private AdvertiseRecordService advertiseRecordService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Object list(HttpServletRequest request) {

        Long clientId = getIdUser(request);

        List<AdvertiseRecord> recordList = advertiseRecordService.findByClientId(clientId);
        return Rets.success(recordList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Object add(@RequestBody AdvertiseRecord advertiseRecord) {
        log.info("advertiseRecord:{}",advertiseRecord);
        User user = userService.get(advertiseRecord.getClinetId());
        advertiseRecord.setClinetId(advertiseRecord.getClinetId());
        advertiseRecord.setClientName(user.getName());
        advertiseRecord.setClientPhone(user.getPhone());
        log.info("advertiseRecord:{}",advertiseRecord);
        AdvertiseRecord insert = advertiseRecordService.insert(advertiseRecord);
        return Rets.success();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json")
    public Object update(@RequestBody AdvertiseRecord advertiseRecord){
        AdvertiseRecord update = advertiseRecordService.update(advertiseRecord);
        return Rets.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    public Object delete(@RequestParam Long id) {
        AdvertiseRecord advertiseRecord = advertiseRecordService.get(id);
        advertiseRecord.setStatus(-1);
        advertiseRecordService.update(advertiseRecord);
        return Rets.success();
    }
}
