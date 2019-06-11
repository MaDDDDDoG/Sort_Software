public class Inspector {
    static public String check_int(String a){
        try{
            Integer.valueOf(a);
            return a;
        }catch (NumberFormatException e){
            return "0";
        }
    }

    static public String check_double(String a){
        try{
            Double.valueOf(a);
            return a;
        }catch (NumberFormatException e){
            return "0";
        }
    }

    static public String check_string(String a){
        if(a.equals("")){
            return "A";
        }else {
            return a;
        }
    }
}
