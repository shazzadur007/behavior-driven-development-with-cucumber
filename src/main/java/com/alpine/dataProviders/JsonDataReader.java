package com.alpine.dataProviders;

import com.alpine.managers.FileReaderManager;
import com.alpine.testDataTypes.Shipper;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String shipperFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Shipper.json";
    private final List<Shipper> shipperList;

    public JsonDataReader(){
        shipperList = getShipperData();
    }

    private @NotNull List<Shipper> getShipperData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(shipperFilePath));
            Shipper[] shippers = gson.fromJson(bufferReader, Shipper[].class);
            return Arrays.asList(shippers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + shipperFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final @NotNull Shipper getShipperById(int shipperId){
        return shipperList.stream().filter(x -> x.id == shipperId).findAny().get();
    }

//    public final Shipper getCustomerByName(int shipperId){
//        for(Shipper shipper : shipperList) {
//            if(shipper.id == shipperId) return shipper;
//        }
//        return null;
//    }
}
