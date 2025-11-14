package com.skillsoft.collections;

import java.util.Objects;

public class Movie {

    private String name;
    private String actor;

    public Movie(String name, String actor) {
        this.name = name;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + actor + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, actor);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Movie)) return false;
        Movie otherMovie = (Movie) other;
        return Objects.equals(this.name, otherMovie.name) &&
               Objects.equals(this.actor, otherMovie.actor);
    }
}
