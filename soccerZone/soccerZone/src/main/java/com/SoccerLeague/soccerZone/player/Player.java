package com.SoccerLeague.soccerZone.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {
    // Fill in the names of the columns
    // @Id Specifies the primary key is String name
    @Id 
    @Column(name = "name", unique = true)
    private String name;
    private String nation;
    private String pos;
    private int age;
    private int mp;
    private int starts;
    private double min;
    private double ast;
    private double gls;
    private double pks;
    private double crdv;
    private double crdr;
    private double xg;
    private double xag;
    private String team;

    // Generate constructor
    // Default
    public Player(){

    }
    // Parameterized
    public Player(int age, double ast, double crdr, double crdv, double gls, double min, int mp, String name, String nation, double pks, String pos, int starts, String team, double xag, double xg) {
        this.age = age;
        this.ast = ast;
        this.crdr = crdr;
        this.crdv = crdv;
        this.gls = gls;
        this.min = min;
        this.mp = mp;
        this.name = name;
        this.nation = nation;
        this.pks = pks;
        this.pos = pos;
        this.starts = starts;
        this.team = team;
        this.xag = xag;
        this.xg = xg;
    }

    public Player(String name){
        this.name = name;
    }

    // Creating getters - allow access and modifications of the fields
    public String getName() {
        return name;
    }
    public String getNation() {
        return nation;
    }
    public String getPos() {
        return pos;
    }
    public int getAge() {
        return age;
    }
    public int getMp() {
        return mp;
    }
    public int getStarts() {
        return starts;
    }
    public double getMin() {
        return min;
    }
    public double getAst() {
        return ast;
    }
    public double getGls() {
        return gls;
    }
    public double getPks() {
        return pks;
    }
    public double getCrdv() {
        return crdv;
    }
    public double getCrdr() {
        return crdr;
    }
    public double getXg() {
        return xg;
    }
    public double getXag() {
        return xag;
    }
    public String getTeam() {
        return team;
    }

    // Creating setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public void setPos(String pos) {
        this.pos = pos;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public void setStarts(int starts) {
        this.starts = starts;
    }
    public void setMin(double min) {
        this.min = min;
    }
    public void setAst(double ast) {
        this.ast = ast;
    }
    public void setGls(double gls) {
        this.gls = gls;
    }
    public void setPks(double pks) {
        this.pks = pks;
    }
    public void setCrdv(double crdv) {
        this.crdv = crdv;
    }
    public void setCrdr(double crdr) {
        this.crdr = crdr;
    }
    public void setXg(double xg) {
        this.xg = xg;
    }
    public void setXag(double xag) {
        this.xag = xag;
    }
    public void setTeam(String team) {
        this.team = team;
    }
}
