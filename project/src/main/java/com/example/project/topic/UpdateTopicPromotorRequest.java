package com.example.project.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UpdateTopicPromotorRequest {
    private final Long topic_id;
    private final Long promotor_id;
    // is het mogelijk om op de promotor toevoegen pagina uit lijst met beschikbare promotors te kiezen
}
