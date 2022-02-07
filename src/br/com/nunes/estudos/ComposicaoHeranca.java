package br.com.nunes.estudos;

public class ComposicaoHeranca {

    public static void main(String[] args) {
        Transport transport1 = new Transport();
        transport1.setD(new Human());
        transport1.setE(new CombustionEngine());

        Transport transport2 = new Transport();
        transport2.setE(new EletricEngine());
        transport2.setD(new Robot());

        transport1.getD().navigate();
        transport1.getE().move();
        System.out.println("-----------");
        transport2.getD().navigate();
        transport2.getE().move();

    }
    static class Transport{
        private Engine e;
        private Driver d;

        public Driver getD() {
            return d;
        }

        public Engine getE() {
            return e;
        }

        public void setD(Driver d) {
            this.d = d;
        }

        public void setE(Engine e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Transport{" +
                    "e=" + e +
                    ", d=" + d +
                    '}';
        }
    }

    interface Engine {
        void move();
    }

    interface Driver {
        void navigate();
    }

    static class CombustionEngine implements Engine {
        @Override
        public void move() {
            System.out.println("Movendo com gasolina");
        }
    }

    static class EletricEngine implements Engine {
        @Override
        public void move() {
            System.out.println("Movendo com energia");
        }
    }

    static class Robot implements Driver{
        @Override
        public void navigate() {
            System.out.println("Pilotado por um robo");
        }

        @Override
        public String toString() {
            return "Navegação robótica";
        }
    }

    static class Human implements Driver {
        @Override
        public void navigate() {
            System.out.println("Piloatado por um humano");
        }
    }
}
