package cn.enilu.flash.service.advertise;

import cn.enilu.flash.bean.entity.advertise.AdvertiseRecord;
import cn.enilu.flash.dao.advertise.AdvertiseRecordRepository;
import cn.enilu.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiseRecordService extends BaseService<AdvertiseRecord,Long, AdvertiseRecordRepository> {

    @Autowired
    private AdvertiseRecordRepository advertiseRecordRepository;

    public List<AdvertiseRecord> findByClientId(Long clientId) {
        return advertiseRecordRepository.findByClientId(clientId);
    }

}
