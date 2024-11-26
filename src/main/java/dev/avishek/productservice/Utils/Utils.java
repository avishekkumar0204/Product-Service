package dev.avishek.productservice.Utils;

import java.util.UUID;

public class Utils {
    public static UUID validateUUID(String uuid){
        UUID validUuid;
        try{
            validUuid = UUID.fromString(uuid);
        }catch (Exception ex){
            throw new IllegalArgumentException("Not a valid UUID");
        }
        return validUuid;
    }

}
