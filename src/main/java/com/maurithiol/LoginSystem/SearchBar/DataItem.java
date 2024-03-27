package com.maurithiol.LoginSystem.SearchBar;

public class DataItem {
    private String symbol;
    private String instrument_name;
    private String exchange;
    private String mic_code;
    private String exchange_timezone;
    private String instrument_type;
    private String country;
    private String currency;

    public String getSymbol() {
        return symbol;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public String getExchange() {
        return exchange;
    }

    public String getMic_code() {
        return mic_code;
    }

    public String getExchange_timezone() {
        return exchange_timezone;
    }

    public String getInstrument_type() {
        return instrument_type;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setMic_code(String mic_code) {
        this.mic_code = mic_code;
    }

    public void setExchange_timezone(String exchange_timezone) {
        this.exchange_timezone = exchange_timezone;
    }

    public void setInstrument_type(String instrument_type) {
        this.instrument_type = instrument_type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
