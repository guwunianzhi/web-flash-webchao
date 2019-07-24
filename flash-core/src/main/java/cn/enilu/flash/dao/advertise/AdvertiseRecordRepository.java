package cn.enilu.flash.dao.advertise;

import cn.enilu.flash.bean.entity.advertise.AdvertiseRecord;
import cn.enilu.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AdvertiseRecordRepository extends BaseRepository<AdvertiseRecord, Long> {

    @Query(nativeQuery = true,value = "select * from t_advertise_record where  client_id = ?")
    List<AdvertiseRecord> findByClientId(Long clientId);
}
