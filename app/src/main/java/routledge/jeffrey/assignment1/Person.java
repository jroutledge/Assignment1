package routledge.jeffrey.assignment1;

import android.view.View;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by jeffreyroutledge on 2017-01-23.
 */

public class Person {
    public String name;
    public Date date;
    public float neck;
    public float bust;
    public float chest;
    public float waist;
    public float hip;
    public float inseam;
    public String comment;

    public Person(String name) {
        this.name = name;
        date = new Date();
        neck =  0f;
        bust = 0f;
        chest = 0f;
        waist= 0f;
        inseam = 0f;
        comment = "";
    }

    public String toString() {
        //when we want to add more things to textview do it herreeee
        String s = "";
        s += name + " " ;
        if ( neck != 0 ) {
            s += neck + " " ;
        }
        if ( bust != 0 ) {
            s += bust + " " ;
        }
        if ( chest != 0 ) {
            s += chest + " " ;
        }
        if ( waist != 0 ) {
            s += waist + " " ;
        }
        if ( hip != 0 ) {
            s += hip + " " ;
        }
        if ( inseam != 0 ) {
            s += inseam + " " ;
        }
        if ( !comment.equals("")) {
            s += comment + " " ;
        }
        s += date;

        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getNeck() {
        return neck;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public float getBust() {
        return bust;
    }

    public void setBust(float bust) {
        this.bust = bust;
    }

    public float getChest() {
        return chest;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getHip() { return hip; }

    public void setHip(float hip) { this.hip = hip; }

    public float getInseam() {
        return inseam;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
