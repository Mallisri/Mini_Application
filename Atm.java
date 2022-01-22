package com.malli;


import java.util.*;
class Atm{
    private static Scanner sc;
    static int arr[]={0,0,0,0};
    static int userAmt[]={0,0,0,0};;
    static int user1Amt=20000;
    public static void addAmount(int amount){
        while(amount>0){
            if(amount>2000){
                amount=amount-2000;
                arr[0]++;
                userAmt[0]++;
            }
            else if(amount>500){
                amount=amount-500;
                arr[1]++;
                userAmt[1]++;
            }

            else if(amount>200){
                amount=amount-200;
                arr[2]++;
                userAmt[2]++;
            }
            else{
                amount=amount-100;
                arr[3]++;
                userAmt[3]++;
            }
        }
        System.out.println("Amount successfully added");
    }
    static int res=0;
    public static void main(String args[]){
        sc=new Scanner(System.in);
        int ch=0;
        do{
            System.out.println("ATM Machine");
            System.out.println("1.Admin login");
            System.out.println("2.User login");
            System.out.println("3.Exit");
            System.out.println("Enter the choice:");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the user name: ");
                    String user = sc.next();
                    System.out.println("Enter the user password");
                    String pswd = sc.next();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if(user.equals("Admin") && pswd.equals("123")){
                        int n=0;
                        do {
                            System.out.println("Welcome Admin");
                            System.out.println("1.Show Amount");
                            System.out.println("2.Add Amount");
                            System.out.println("3.Exit");
                            System.out.println("Enter the Choice:");
                            n=sc.nextInt();
                            switch (n){
                                case 1:
                                    for (int i = 0; i < arr.length; i++) {
                                        if(i==0)
                                            System.out.println("2000 => "+arr[i]+" ");
                                        else if(i==1)
                                            System.out.println("500 => "+arr[i]+" ");
                                        else if(i==2)
                                            System.out.println("200 => "+arr[i]+" ");
                                        else if(i==3)
                                            System.out.println("100 => "+arr[i]+" ");
                                    }
                                    System.out.println("Total amount present : "+res);
                                    break;
                                case 2:
                                    System.out.println("Enter the amount to be added");
                                    int amt=sc.nextInt();
                                    res +=amt;
                                    addAmount(amt);
                                    break;
                                case 3:
                                    System.out.println("Thank you Admin");
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }

                        } while (n!=3);

                    }
                    else{
                        System.out.println("Invalid Admin");
                    }
                    break;

                case 2:
                    System.out.println("Enter the User ID");
                    String id = sc.next();
                    System.out.println("Enter the User Password");
                    String password = sc.next();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if(id.equals("user1") && password.equals("1234")){
                        int opt=0;
                        do{
                            System.out.println("Welcome User1");
                            System.out.println("1.Balance");
                            System.out.println("2.Withdraw Amount");
                            System.out.println("3.Exit");
                            System.out.println("Enter Your Choice:");
                            opt =sc.nextInt();
                            switch(opt){
                                case 1:
                                    addAmount(user1Amt);
                                    for (int i = 0; i < arr.length; i++) {
                                        if(i==0)
                                            System.out.println("2000 => "+userAmt[i]+" ");
                                        else if(i==1)
                                            System.out.println("500 => "+userAmt[i]+" ");
                                        else if(i==2)
                                            System.out.println("200 => "+userAmt[i]+" ");
                                        else if(i==3)
                                            System.out.println("100 => "+userAmt[i]+" ");
                                    }
                                    System.out.println("Total amount of User1 : "+ user1Amt);
                                    break;
                                case 2: //withdraw
                                    System.out.println("Enter the withdraw amount :");
                                    int withdraw = sc.nextInt();
                                    user1Amt = user1Amt-withdraw;
                            }
                        }

                        while(opt!=3);
                    }
                    else{
                        System.out.println("Invalid user Id or Password");
                        System.out.println("Press enter to continue");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        while(ch!=3);

    }
}
