package cn.edu.guet.weappdemo.bean;


import java.util.Objects;

public class FoodMenu {
    private int Menu_Id;
    private int Menu_Form;
    private String Menu_Name;
    private double Menu_Price;
    private int Menu_Count;
    private String Menu_Icon;
    private String Menu_detail;

    public int getMenu_Id() {
        return Menu_Id;
    }

    public void setMenu_Id(int menu_Id) {
        Menu_Id = menu_Id;
    }

    public String getMenu_Name() {
        return Menu_Name;
    }

    public void setMenu_Name(String menu_Name) {
        Menu_Name = menu_Name;
    }

    public double getMenu_Price() {
        return Menu_Price;
    }

    public void setMenu_Price(double menu_Price) {
        Menu_Price = menu_Price;
    }

    public int getMenu_Form() {
        return Menu_Form;
    }

    public void setMenu_Form(int menu_Form) {
        Menu_Form = menu_Form;
    }

    public int getMenu_Count() {
        return Menu_Count;
    }

    public void setMenu_Count(int menu_Count) {
        Menu_Count = menu_Count;
    }

    public String getMenu_Icon() {
        return Menu_Icon;
    }

    public void setMenu_Icon(String menu_Icon) {
        Menu_Icon = menu_Icon;
    }

    public String getMenu_detail() {
        return Menu_detail;
    }

    public void setMenu_detail(String menu_detail) {
        Menu_detail = menu_detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodMenu foodMenu = (FoodMenu) o;
        return Menu_Id == foodMenu.Menu_Id && Double.compare(foodMenu.Menu_Price, Menu_Price) == 0 && Menu_Form == foodMenu.Menu_Form && Menu_Count == foodMenu.Menu_Count && Objects.equals(Menu_Name, foodMenu.Menu_Name) && Objects.equals(Menu_Icon, foodMenu.Menu_Icon) && Objects.equals(Menu_detail, foodMenu.Menu_detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Menu_Id, Menu_Name, Menu_Price, Menu_Form, Menu_Count, Menu_Icon, Menu_detail);
    }

    @Override
    public String toString() {
        return "FoodMenu{" +
                "Menu_Id=" + Menu_Id +
                ", Menu_Name='" + Menu_Name + '\'' +
                ", Menu_Price=" + Menu_Price +
                ", Menu_Form=" + Menu_Form +
                ", Menu_Count=" + Menu_Count +
                ", Menu_Icon='" + Menu_Icon + '\'' +
                ", Menu_detail='" + Menu_detail + '\'' +
                '}';
    }
}
