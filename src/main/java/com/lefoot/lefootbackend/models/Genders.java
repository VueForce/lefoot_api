package com.lefoot.lefootbackend.models;

public enum Genders {
  MALE("male"),
  FEMALE("female"),
  OTHER("other");

  private String gender;

  Genders(String gender) {
    this.gender = gender;
  }
}
