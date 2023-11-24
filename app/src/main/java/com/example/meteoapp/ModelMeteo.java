package com.example.meteoapp;

import java.util.ArrayList;

public class ModelMeteo {

    String cod, message, cnt;

    ArrayList<ModelMeteo.Prevision> list;

    City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public ArrayList<Prevision> getPrevision() {
        return list;
    }

    public void setPrevision(ArrayList<Prevision> prevision) {
        this.list = prevision;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    ////////////////////
    public class Prevision{

        String dt, visibility, pop, dt_txt;

        ArrayList<Prevision.Meteo> weather;

        Main main;

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public void setDt_txt(String dt_txt) {
            this.dt_txt = dt_txt;
        }

        public ArrayList<Meteo> getWeather() {
            return weather;
        }

        public void setWeather(ArrayList<Meteo> weather) {
            this.weather = weather;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        Clouds clouds;
        Wind wind;
        Sys sys;

        public class Meteo{

            String id, main,description, icon;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }


        public class Main{

            String temp, feels_like, temp_min,temp_max, pressure,sea_level, grnd_level, humidity, temp_kf;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getFeels_like() {
                return feels_like;
            }

            public void setFeels_like(String feels_like) {
                this.feels_like = feels_like;
            }

            public String getTemp_min() {
                return temp_min;
            }

            public void setTemp_min(String temp_min) {
                this.temp_min = temp_min;
            }

            public String getTemp_max() {
                return temp_max;
            }

            public void setTemp_max(String temp_max) {
                this.temp_max = temp_max;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getSea_level() {
                return sea_level;
            }

            public void setSea_level(String sea_level) {
                this.sea_level = sea_level;
            }

            public String getGrnd_level() {
                return grnd_level;
            }

            public void setGrnd_level(String grnd_level) {
                this.grnd_level = grnd_level;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTemp_kf() {
                return temp_kf;
            }

            public void setTemp_kf(String temp_kf) {
                this.temp_kf = temp_kf;
            }
        }

        public class Clouds{

            String all;

            public String getAll() {
                return all;
            }

            public void setAll(String all) {
                this.all = all;
            }
        }

        public class Wind{

            String speed, deg, gust;

            public String getSpeed() {
                return speed;
            }

            public void setSpeed(String speed) {
                this.speed = speed;
            }

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getGust() {
                return gust;
            }

            public void setGust(String gust) {
                this.gust = gust;
            }
        }

        public class Sys{

            String pop;

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }
        }

    }

    public class City{

        String id, name, country, population, timezone, sunrise, sunset;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public class Coordonee{

            String lat, lon;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }
        }
    }
}
