package com.ben.smith.reader;

/**
 * Created by bensmith on 11/7/17.
 * This is our asset object which holds the crucial info from our 13f filings
 */
public class Asset {

    public String cik;
    public String confirmation_period;

    public String name;
    public String title;
    public String cusip;
    public String excel_cusip;
    public String cash_value;
    public String num_shares;
    public String type;
    public String discretion;
    public String submit_date;

    // The only constructor we should need, we add the cik and confirmation_period later
    public Asset(String name, String title, String cusip, String cash_value, String num_shares, String type, String discretion) {
        this.name = name;
        this.title = title;
        this.cusip = cusip;
        this.excel_cusip = "#" + cusip;
        this.cash_value = cash_value;
        this.num_shares = num_shares;
        this.type = type;
        this.discretion = discretion.toUpperCase();
    }

    // Add the cik and confirmation_period of the asset to this asset object
    public void add_identifying_info(String cik, String confirmation_period, String submit_date) {
        this.cik = cik;
        this.confirmation_period = fix_date(confirmation_period);
        this.submit_date = fix_date(submit_date);
    }

    // 20170630 -> 2017-06-30, fix the date so that it conforms to yyyy-mm-dd
    public String fix_date(String bad_date) {
        String good_date = bad_date.substring(0, 4) + "-";
        good_date += bad_date.substring(4, 6) + "-";
        good_date += bad_date.substring(6);
        return good_date;
    }

    // Used to form the assets data into a line to insert into a csv
    public String get_csv_line() {
        String line = "";
        line += "\"" + cik + "\",";
        line += "\"" + confirmation_period + "\",";
        line += "\"" + name + "\",";
        line += "\"" + title + "\",";
        line += "\"" + cusip + "\",";
        line += "\"" + excel_cusip + "\",";
        line += "\"" + cash_value + "\",";
        line += "\"" + num_shares + "\",";
        line += "\"" + type + "\",";
        line += "\"" + discretion + "\",";
        line += "\"" + submit_date + "\"";
        return line;
    }

    // Used mainly for debugging to check that all of the values of the asset are correct
    public void print_all_fields() {
        System.out.printf("cik: %s\n", cik);
        System.out.printf("confirmation_period: %s\n", confirmation_period);
        System.out.printf("name: %s\n", name);
        System.out.printf("title: %s\n", title);
        System.out.printf("cusip: %s\n", cusip);
        System.out.printf("excel_cusip: %s\n", excel_cusip);
        System.out.printf("cash_value (x$1000): %s\n", cash_value);
        System.out.printf("num_shares: %s\n", num_shares);
        System.out.printf("type: %s\n", type);
        System.out.printf("discretion: %s\n", discretion);
        System.out.println("==============================");
    }

    /*
    *
    * Boilerplate getters/setters below, no need to go into those
    *
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getExcel_cusip() {
        return excel_cusip;
    }

    public void setExcel_cusip(String excel_cusip) {
        this.excel_cusip = excel_cusip;
    }

    public String getCash_value() {
        return cash_value;
    }

    public void setCash_value(String cash_value) {
        this.cash_value = cash_value;
    }

    public String getNum_shares() {
        return num_shares;
    }

    public void setNum_shares(String num_shares) {
        this.num_shares = num_shares;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscretion() {
        return discretion;
    }

    public void setDiscretion(String discretion) {
        this.discretion = discretion;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    public String getConfirmation_period() {
        return confirmation_period;
    }

    public void setConfirmation_period(String confirmation_period) {
        this.confirmation_period = confirmation_period;
    }

    public String getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }
}

