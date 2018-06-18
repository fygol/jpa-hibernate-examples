package io.examples.hibernate.one_to_one;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_details")
@Getter
@Setter
public class PostDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public PostDetails() {}

    public PostDetails(String createdBy) {
        createdOn = new Date();
        this.createdBy = createdBy;
    }
}
