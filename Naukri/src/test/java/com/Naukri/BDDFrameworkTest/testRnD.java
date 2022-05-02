package com.Naukri.BDDFrameworkTest;

import java.util.stream.IntStream;

public class testRnD {

    public static void main(String[] args) {
//		ConfigFileReader c=new ConfigFileReader();
//		System.out.println(c.getApplicationUrl().toString());
        Restaurant rs = Restaurant.getInstance("ABC", "DEF", "XYZ");
        Restaurant rs1 = Restaurant.getInstance("PQR", "SYZ", "ggg");


        IntStream.range(0, 20).forEach((i) -> {
            System.out.println(rs.getName());
            System.out.println(rs.getAddress());
            System.out.println(rs.hashCode());
            System.out.println("Count :" + i);
            System.out.println(rs1.getName());
            System.out.println(rs1.getAddress());
            System.out.println(rs1.hashCode());
        });

    }


}

class Restaurant {

    public static final Restaurant restaurent = new Restaurant("A", "B", "c");
    private String name;
    private String address;
    private String type;

    public Restaurant(String a, String b, String c) {
        this.name = a;
        this.address = b;
        this.type = c;
    }


	/*private Restaurant(String name, String address, String type) {
		this.name = name;
		this.address = address;
		this.type = type;
	}*/

    public static Restaurant getInstance(String name, String address, String type) {

        return restaurent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

/*class Sharbidaya extends Restaurant{

	public Sharbidaya(String name, String address, String type) {
		super(name, address, type);
	}
}

class Arafa extends Restaurant{

	public Arafa(String name, String address, String type) {
		super(name, address, type);
	}*/


class Items {

}