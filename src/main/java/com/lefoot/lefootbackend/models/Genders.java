package com.lefoot.lefootbackend.models;

public enum Genders {
  MALE("male"),
  FEMALE("female")

  private String gender;

  Genders(String gender) {
    this.gender = gender;
  }
}
