import org.junit.Test;

public class StaticTester {



    private final String hh = "hh";
    private  String xx = "hh";

    private static Integer num = 0;

    static{
        num++;
    }


    public static void hh(){
       num++;
    }

    public  void changeFinal(){
        xx = "wwwwwwwwww";
    }

    @Test
    public  void changeNumber(){
        StaticTester.hh();
        StaticTester.hh();
        StaticTester.hh();
        StaticTester.hh();

    }

    @Test
    public  void caseTest() {
        int a = 100;
       if(a == 100){
           System.out.println("哈哈");
       }else  if(a >10){
           System.out.println("哈哈2");

       }else if(a <200){
           System.out.println("哈哈3");
       }
    }


    @Test
    public  void caseTest2() {
        StaticTester staticTester = new StaticTester();
        Integer num =  staticTester.retrunTest();
        System.out.println(num);
    }

    @Test
    public  void caseTest3() {

        int a = 3;
        switch (a){
            case 3:{

            }
        }
    }

    @Test
    public  void whileTest3() {

        int a = 0;


        do{
           a++;
        }while(a==0);


        int i = 0;
        for( i = 0 ;i < 10 ; i ++){



            if(i ==4){
                {
                    continue;
                }
            }

        }
        System.out.println(i);

    }

    public  Integer retrunTest(){

        int num = 2;
        try{
            num ++;
            throw  new NullPointerException("异常啦");
        }catch (ArrayIndexOutOfBoundsException e){
            num ++;
            return num;
        }catch (NullPointerException e){
            num ++;
            return num;
        }finally {
            num++;
        }

    }


    public  void arrayTest(){

        int[] array = {1,2,3} ;
        array = new int[]{1,2,3,4};

        String x = "22";
        Integer i = Integer.parseInt(x);
        Double d = Double.parseDouble(x);
        Float f = Float.parseFloat(x);

    }

    public void stringBufferAndBuilder(){

        String a = "你好";
        String b = "世界";
        String c = a+b;
        System.out.println(c.toString());
        StringBuilder sb = new StringBuilder("你好");
        sb.append("世界");
        System.out.println(sb.toString());

        StringBuffer sba = new StringBuffer("你好");
        sba.append("世界");
        System.out.println(sba.toString());


    }



    interface Inter{

        void eatInter();
    }

    interface Inter2{

        void eatInter2();
    }

    class Father {

        public void eat(){
            System.out.println("赶快回家吃饭");
        }
    }


    class children extends Father implements Inter,Inter2{


        public void eat(){
            super.eat();
            System.out.println("知道了马上回");
        }

        public void eat(String o){
            System.out.println("知道了马上回");
        }

        @Override
        public void eatInter() {

        }

        @Override
        public void eatInter2() {

        }
    }



    public void testOverwrite(){

        Father one = new children();
        one.eat();
        children two = new children();
        two.eat("哦");
    }

}
