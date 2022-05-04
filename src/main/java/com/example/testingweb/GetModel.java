package com.example.testingweb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class GetModel {
    private String name;
//    private LocalDateTime requestDateTime;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date requestDateTime;
}