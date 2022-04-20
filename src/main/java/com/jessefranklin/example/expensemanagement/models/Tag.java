package com.jessefranklin.example.expensemanagement.models;

import com.jessefranklin.example.expensemanagement.models.enumerations.TagEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TagEnum tagEnum;

    public static Tag toEntity(TagEnum tagEnum) {
        Tag tag = new Tag();
        tag.setTagEnum(tagEnum);
        return tag;
    }
}
