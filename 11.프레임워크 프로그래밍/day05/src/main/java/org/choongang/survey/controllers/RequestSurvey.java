package org.choongang.survey.controllers;

import lombok.Data;

@Data
public class RequestSurvey { // 커멘드 객체?
    private String q1;
    private String q2;
    private String q3;
    private String q4;
}
