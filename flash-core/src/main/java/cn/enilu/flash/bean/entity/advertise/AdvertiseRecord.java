package cn.enilu.flash.bean.entity.advertise;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.io.Serializable;
import java.util.Date;

/**
 * @author rfc
 */

@Entity(name = "t_advertise_record")
@Table(appliesTo = "t_advertise_record", comment = "广告记录")
@Data
@EntityListeners(AuditingEntityListener.class)
public class AdvertiseRecord extends BaseEntity implements Serializable {


    @Column(name = "client_id")
    private Long clinetId;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_phone")
    private String clientPhone;
    @Column
    private String source;
    @Column
    private Integer status;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
}
