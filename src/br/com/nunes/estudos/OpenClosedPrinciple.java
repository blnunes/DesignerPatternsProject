package br.com.nunes.estudos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OpenClosedPrinciple {
    //AS CLASSES DEVEM SER ABERTAS PARA EXTENSÃO E FECHADAS PARA MODIFICAÇÃO

    interface Shipping {
        double getCost(Order order);

        Date getDate(Order order);
    }

    class WrongOrder {
        List<String> lineItens;
        String shipping;

        public Integer getTotal() {
            return 1;
        }

        public Integer getTotalWeigth() {
            return 10;
        }

        public void setShippingType(String shippingType) {
            this.shipping = shippingType;
        }

        /*
            Dessa maneira eu sempre terei que adicionar novos tipos nessa classe, o que é arriscado
            pois quanto mais se altera, mais arriscado de quebrar o que já está funcionando.
         */
        public double getShppingCost() {
            if (Objects.equals(this.shipping, "ground")) {
                if (getTotal() > 100) {
                    return 0.0;
                }
                return Math.max(10, getTotalWeigth() * 1.5);
            }

            if (this.shipping.equals("air")) {
                return Math.max(20, getTotalWeigth() * 3);
            }
            return 0.0;
        }

        public Date getShippingDate() {
            return new Date();
        }
    }

    static class Order {
        List<String> lineItens;
        Shipping shipping;


        public Integer getTotal() {
            return 11;
        }

        public Integer getTotalWeigth() {
            return 10;
        }

        public void setShippingType(Shipping shippingType) {
            this.shipping = shippingType;
        }

        /*
            Dessa maneira eu sempre terei que adicionar novos tipos nessa classe, o que é arriscado
            pois quanto mais se altera, mais arriscado de quebrar o que já está funcionando.
         */
        public double getShppingCost() {
            return this.shipping.getCost(this);
        }

        public Date getShippingDate() {
            return this.shipping.getDate(this);
        }
    }

    static class Ground implements Shipping {

        @Override
        public double getCost(Order order) {
            if (order.getTotal() > 100) {
                return 0;
            }
            return Double.max(10, order.getTotalWeigth() * 1.5);
        }

        @Override
        public Date getDate(Order order) {
            return new Date();
        }
    }

    static class Air implements Shipping {

        @Override
        public double getCost(Order order) {
            return Double.max(20, order.getTotalWeigth() * 1.5);
        }

        @Override
        public Date getDate(Order order) {
            return new Date();
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setShippingType(new Air());
//        order.setShippingType(new Ground());

        System.out.println(order.getShppingCost());
    }
}
