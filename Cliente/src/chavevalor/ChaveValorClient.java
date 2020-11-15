/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ChaveValorClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ChaveValor.Client client = new ChaveValor.Client(protocol);
            
            System.out.println("Current string = " + client.setKV(1, "Test #1"));
            System.out.println("Current string = " + client.setKV(2, "Test #2"));
            System.out.println("Current string = " + client.setKV(1, "Test #3"));
            System.out.println("Current string = " + client.setKV(3, "Test #4"));
            System.out.println("Current string = " + client.setKV(3, "Test #5"));
            
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}
