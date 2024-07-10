package com.santander.eventos.translator.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.santander.eventos.translator.Transactions.Mp7e;

@RestController
public class RequestController {

    @PostMapping("/event-transalate")
    public String translateEvent(@RequestBody String eventString) {
                
try{        
    eventString.replace("eventMetadata","eventHeader");
        
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("1");
            System.out.println();
            JsonNode rootNode = objectMapper.readTree(eventString);
            System.out.println(rootNode);
            System.out.println("2");
            ObjectNode objectNode = (ObjectNode) rootNode;
            System.out.println(objectNode);
            
            JsonNode evmetdtNode = rootNode.get("eventMetadata");
            objectNode.put("eventHeader", rootNode.get("eventMetadata"));
            objectNode.remove("eventMetadata");
            System.out.println("****************");
            System.out.println(objectNode);
            String reftrans = evmetdtNode.get("refTrans").asText();
            System.out.println(reftrans);

        }
        catch(Exception e){
            e.printStackTrace();
        }
return eventString.toString();
    }
}