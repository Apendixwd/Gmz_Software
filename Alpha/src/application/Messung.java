package application;

    public class Messung {

        private String Zeit = null;
        private String Cpm = null;

        public Messung() {
        }

        public Messung(String Zeit, String Cpm) {
            this.Zeit = Zeit;
            this.Cpm = Cpm;
        }

        public String getZeit() {
            return Zeit;
        }

        public void setZeit(String Zeit) {
            this.Zeit = Zeit;
        }

        public String getCpm() {
            return Cpm;
        }

        public void setCpm(String Cpm) {
            this.Cpm = Cpm;
        }
    }

