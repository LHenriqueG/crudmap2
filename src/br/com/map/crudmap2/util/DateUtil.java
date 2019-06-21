/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Allyson
 */
public class DateUtil {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    private static DateUtil instance;

    private DateUtil() {

    }

    public static DateUtil getInstance() {
        if (instance == null) {
            instance = new DateUtil();
        }
        return instance;
    }

    public static Date stringToDate(String dataStr) {
        try {
            return FORMATTER.parse(dataStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date data) {
        if (data != null) {
            return FORMATTER.format(data);
        }
        return "Não Informado";

    }
}
