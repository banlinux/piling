package com.sil.util;

import java.io.PrintWriter;


public class AjaxXMLStreamWriter
{
    private PrintWriter pw;

    private String filter (String s)
    {
        return (s.replaceAll ("&", "&amp;"));
    }

    /**
     * Creates a new instance of AjaxXMLStreamWriter
     */
    public AjaxXMLStreamWriter (PrintWriter out)
    {
        pw = out;
    }

    public void println (String x)
    {
        pw.println (filter (x));
    }
}
