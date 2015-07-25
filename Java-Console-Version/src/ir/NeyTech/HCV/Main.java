package ir.NeyTech.HCV;

public class Main {
    public static void main(String[] args) {
        switch(args.length) {
            default:
                System.out.println("==========HamyarNet Charge Viewer==========");
                System.out.println("Programmer : Hamid reza kaveh pishghadam.");
                System.out.println("Usage : java hamyar.class username password [Optional : gig , charge , created , expire , savedgig , savedcharge , freenight ]");
                System.out.println("Example : java hamyar.class username password  # will show all information");
                System.out.println("Example : java hamyar.class username password gig  # will show only gig value");
                System.out.println("Example : java hamyar.class username password charge  # will show only charge value");
                break;
            case 2:
                String[] result = get_data.main(args[0], args[1]);
                if(result[0] == null){
                    System.out.println("Usernaem or/and password is wrong.or check internet connection.");
                    break;
                }
                System.out.println("GIG :" + result[0]);
                System.out.println("Charge :" + result[1]);
                System.out.println("Created In :" + result[2]);
                System.out.println("Expire In :" + result[3]);
                System.out.println("Saved GIG :" + result[4]);
                System.out.println("Saved Charge :" + result[5]);
                System.out.println("Free Night :" + result[6]);
                System.out.println("UserName :" + result[7]);
                break;
            case 3:
                String[] result1 = get_data.main(args[0], args[1]);
                switch (args[2]){
                    case "gig":
                        System.out.println(result1[0]);
                        break;
                    case "charge":
                        System.out.println(result1[1]);
                        break;
                    case "created":
                        System.out.println(result1[2]);
                        break;
                    case "expire":
                        System.out.println(result1[3]);
                        break;
                    case "savedgig":
                        System.out.println(result1[4]);
                        break;
                    case "savedcharge":
                        System.out.println(result1[5]);
                        break;
                    case "freenight":
                        System.out.println(result1[6]);
                        break;

                }

        }


    }
}
