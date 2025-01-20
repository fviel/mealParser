package com.fviel.mealParser.meal.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Meal {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("user_id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("user_id")})
    private String userID;
    @lombok.Getter(onMethod_ = {@JsonProperty("age")})
    @lombok.Setter(onMethod_ = {@JsonProperty("age")})
    private String age;
    @lombok.Getter(onMethod_ = {@JsonProperty("user_weight")})
    @lombok.Setter(onMethod_ = {@JsonProperty("user_weight")})
    private String userWeight;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("price")})
    @lombok.Setter(onMethod_ = {@JsonProperty("price")})
    private double price;
    @lombok.Getter(onMethod_ = {@JsonProperty("weight")})
    @lombok.Setter(onMethod_ = {@JsonProperty("weight")})
    private long weight;
    @lombok.Getter(onMethod_ = {@JsonProperty("calories")})
    @lombok.Setter(onMethod_ = {@JsonProperty("calories")})
    private long calories;
    @lombok.Getter(onMethod_ = {@JsonProperty("fat")})
    @lombok.Setter(onMethod_ = {@JsonProperty("fat")})
    private double fat;
    @lombok.Getter(onMethod_ = {@JsonProperty("carbs")})
    @lombok.Setter(onMethod_ = {@JsonProperty("carbs")})
    private double carbs;
    @lombok.Getter(onMethod_ = {@JsonProperty("protein")})
    @lombok.Setter(onMethod_ = {@JsonProperty("protein")})
    private double protein;
    @lombok.Getter(onMethod_ = {@JsonProperty("time_consumed")})
    @lombok.Setter(onMethod_ = {@JsonProperty("time_consumed")})
    private String timeConsumed;
    @lombok.Getter(onMethod_ = {@JsonProperty("date_consumed")})
    @lombok.Setter(onMethod_ = {@JsonProperty("date_consumed")})
    private LocalDate dateConsumed;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
    @lombok.Getter(onMethod_ = {@JsonProperty("favorite")})
    @lombok.Setter(onMethod_ = {@JsonProperty("favorite")})
    private String favorite;
    @lombok.Getter(onMethod_ = {@JsonProperty("procedence")})
    @lombok.Setter(onMethod_ = {@JsonProperty("procedence")})
    private String procedence;
}