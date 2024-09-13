package Streams;

public class Student {
	private String name;
    private int gradePeriod1;
    private int gradePeriod2;

    public Student(String name, int gradePeriod1, int gradePeriod2) {
        this.name = name;
        this.gradePeriod1 = gradePeriod1;
        this.gradePeriod2 = gradePeriod2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradePeriod1() {
        return gradePeriod1;
    }

    public void setGradePeriod1(int gradePeriod1) {
        this.gradePeriod1 = gradePeriod1;
    }

    public int getGradePeriod2() {
        return gradePeriod2;
    }

    public void setGradePeriod2(int gradePeriod2) {
        this.gradePeriod2 = gradePeriod2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradePeriod1=" + gradePeriod1 +
                ", gradePeriod2=" + gradePeriod2 +
                '}';
    }

}
