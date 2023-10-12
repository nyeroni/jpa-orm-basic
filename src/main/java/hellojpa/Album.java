package hellojpa;

import jakarta.persistence.*;

@Entity
public class Album extends Item {
    private  String artist;
}
