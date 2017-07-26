package com.javarush.test.level21.lesson16.big01;

/**
 * Created by osas on 03.01.2017.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move()
    {
        double randomIndex = Math.random();
        distance += speed * randomIndex;
    }

    public void print()
    {
        String result = "";
        for (int i = 0; i < Math.round(distance); i++)
        {
            result += ".";
        }
        System.out.println(result + getName());
    }
}
