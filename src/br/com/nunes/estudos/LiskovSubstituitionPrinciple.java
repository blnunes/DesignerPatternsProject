package br.com.nunes.estudos;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LiskovSubstituitionPrinciple {
    /*
        QUANDO ESTENDENDO UMA CLASSE, LEMBRE-SE QUE VOCÊ DEVE SER CAPAZ DE PASSAR OBJETOS DA SUBLCASSE
        EM LUGAR DE OBJETOS DA CLASSE MÃE SEM QUEBRAR O CÓDIGO CLIENTE
     */

    //EXEMPLO RUIM

    abstract static class WrongDocument {
        private Date date;
        private String fileName;

        void open(){
            System.out.println("abriu");
        }

        abstract void save() throws Exception;
    }

    static class ReadOnlyDocument extends WrongDocument {
        @Override
        void save() throws Exception {
            throw new Exception("Somente leitura");
        }
    }

    static class WriteOnlyDocument extends WrongDocument {

        @Override
        void save() throws Exception {
            System.out.println("Salvo com sucesso!");
        }
    }

    static class Project {
        List<WrongDocument> wrongDocumentList;

        void openAll() {
            wrongDocumentList.forEach(WrongDocument::open);
        }

        public void setWrongDocumentList(List<WrongDocument> wrongDocumentList) {
            this.wrongDocumentList = wrongDocumentList;
        }

        void salveAll() {
            wrongDocumentList.forEach(wrongDocument -> {
                try {
                    //NECESSÁRIO PARA VALIDAR O DOCUMENTO READONLY
                    if (!(wrongDocument instanceof ReadOnlyDocument)) {
                        wrongDocument.save();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public static void main(String[] args) throws Exception {
        //TESTES ERRADOS
//        Project p = new Project();
//        WrongDocument readOnlyDocument = new ReadOnlyDocument();
//        WrongDocument writeOnlyDocument = new WriteOnlyDocument();
//
//        List<WrongDocument> wrongDocumentList = new ArrayList<>();
//
//        wrongDocumentList.add(readOnlyDocument);
//        wrongDocumentList.add(writeOnlyDocument);
//
//        p.setWrongDocumentList(wrongDocumentList);
//        p.salveAll();

        //TESTES CORRETOS
        Project2 p2 = new Project2();
        p2.setWiritableDocuments(preencheDocsWriter());
        p2.setAllDocs(preencheDocsWriter());
        p2.salveAll();
        p2.openAll();

    }

    public static List<Document> preencheDocsWriter(){
        ArrayList<Document> wiritableDocuments = new ArrayList<>();
        for (int i=0; i < 10 ; i++) {
            WiritableDocument wiritableDocument = new WiritableDocument();
            wiritableDocuments.add(wiritableDocument);
        }
        return wiritableDocuments;
    }

    public static List<Document> preencheDocs(){
        ArrayList<Document> documents = new ArrayList<>();
        for (int i=0; i < 10 ; i++) {
            ReadDocument document = new ReadDocument();
            documents.add(document);
        }
        return documents;
    }

    abstract static class Document {
        Date data;
        String fileName;

        static void open(Document d){
            System.out.println("abriu "+ d);
        }
    }

    static  class Project2 extends Document {
        List<Document> allDocs;
        List<Document> wiritableDocuments;

        public void setAllDocs(List<Document> allDocs) {
            this.allDocs = new ArrayList<>();
            this.allDocs.addAll(allDocs);
            this.allDocs.addAll(wiritableDocuments);
        }

        public void setWiritableDocuments(List<Document> wiritableDocuments) {
            this.wiritableDocuments = wiritableDocuments;
        }

        public static void preencheListaEscrita() {

        }
        void openAll() {
            allDocs.forEach(Document::open);
        }

        void salveAll() {
           wiritableDocuments.forEach(WiritableDocument::save);
        }
    }

    static class WiritableDocument extends Document{



        public static void save(Document document) {
            System.out.println("salvou "+ document);
        }
    }

    static class ReadDocument extends Document{

    }

}
