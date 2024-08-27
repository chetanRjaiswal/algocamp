package Uber.ReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity means auto-increment
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)//this annotaion tells spring about the format of Date Object to be stored.
    @CreatedDate// this annotation tells spring that only handle it for object creation.
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)//this annotaion tells spring about the format of Date Object to be stored.
    @LastModifiedDate// this annotation tells spring that only handle it for object upadate.
    protected Date upadatedAt;
}
