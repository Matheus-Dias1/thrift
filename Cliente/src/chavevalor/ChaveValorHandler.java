/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chavevalor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {

    private HashMap<Integer, String> kv = new HashMap<>();

    @Override
    public String getKV(int key) throws TException {
        if (kv.containsKey(key)) {
            return kv.get(key);
        } else {
            throw new KeyNotFound();
        }
    }

    @Override
    public String setKV(int key, String valor) throws TException {
        if (kv.containsKey(key)) {
            return kv.get(key);
        } else{
            kv.put(key, valor);
            return valor;
        }
        

    }

    @Override
    public void delKV(int key) throws TException {
        kv.remove(key);
    }
}
