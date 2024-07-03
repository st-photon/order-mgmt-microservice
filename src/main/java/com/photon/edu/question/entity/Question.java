package com.photon.edu.question.entity;

import com.photon.edu.chapter.entity.Chapter;
import com.photon.edu.question.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "question")
@Entity(name = "Question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "qst_id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(name = "topic", nullable = false)
    @Basic(optional = false)
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chapter_id")
    private Chapter chapter;

    @Column(name="qst_type", nullable = false)
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private QuestionType qstType;

    @Column(name = "qst__no", nullable = false)
    @Basic(optional = false)
    private Float qstNo;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Version
    public Long version;
}
