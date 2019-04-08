package _4721;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bankIO {


    public List<Account> getBankAccounts(String filename) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
        List<Account> accs = new ArrayList<Account>();

        while (reader.hasNext()) {
            String s = reader.next();
            String[] a = s.split(",");
            accs.add(new Account(Double.valueOf(a[0]), Double.valueOf(a[1]), a[2]));
        }

        return accs;

    }
}