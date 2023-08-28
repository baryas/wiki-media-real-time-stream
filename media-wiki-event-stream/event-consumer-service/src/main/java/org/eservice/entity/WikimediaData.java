package org.eservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WikimediaData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
