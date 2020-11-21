package com.wm.desiger.abstruct;

public class Test {
    public static void main(String[] args) {
        Alog<Integer> obj = new Alog<>();
        ILess<Integer> cmp = new InteLess();
        Integer a[] = {3,9,2,8};

        Integer max = obj.getMax(a,cmp);
        System.out.println("Integer max = " + max);

        Alog<Student> obj2 = new Alog<>();
        ILess<Student> cmp2 = new StudLess();
        Student s[] = {new Student("li",70),new Student("sun",90),new Student("zhao",80)};
        Student max2 = obj2.getMax(s,cmp2);
        System.out.println("Student max grade : " + max2.grade);
    }
}
