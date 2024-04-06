package com.kukerton.global.enums;

import lombok.Getter;

@Getter
public enum Category {

    SELF_IMPROVEMENT("자기계발"),
    WORKOUT("운동"),
    ACTIVITY("액티비티"),
    NIGHT_EATING("야식"),
    MUSIC("음악"),
    GAME("게임"),
    WATCHING_MEDIA("미디어 시청"),
    OUTGOING("외출"),
    CLEANING("청결(청소)"),
    ETC("기타"),
    DRINKING_AND_SMOKING("음주&흡연"),
    DELIVERY_FOOD("배달음식"),
    IMPULSE_BUYING("충동구매"),
    CAFFEINE("카페인"),
    OVERSPENDING("과소비");

    private String category;

    Category(String category){
        this.category = category;
    }

    public static Category fromRequest(String category){
        for(Category e : Category.values()){
            if(e.category.equals(category))
                return e;
        }
        return null;
    }
}
