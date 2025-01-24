package payloads;

import com.github.javafaker.Faker;
import model.Pet;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Utils.getPetKind;

public class PetPayload {

    public static Faker fake = new Faker();
    public static Pet pet = new Pet();

    public Pet postPet(){

        HashMap<String,String> categoryMap = new HashMap<String, String>();

        if (getPetKind().contentEquals("Dog")) {
            categoryMap.put("id", "1");
            categoryMap.put("name", "Dogs");
            pet.setName(fake.dog().name());
        }
        else if (getPetKind().contentEquals("Cat")){
            categoryMap.put("id", "2");
            categoryMap.put("name", "Cats");
            pet.setName(fake.cat().name());
        }

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add(fake.internet().url());

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","10");
        tag.put("name","myTag");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(fake.number().numberBetween(11, 100));
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;

    }

    public Pet putPet(int petID)
    {
        pet = new Pet();

        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add(fake.internet().url());

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","11");
        tag.put("name","netTag");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(petID);
        pet.setName(fake.dog().name()+"Updated");
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");
        return pet;
    }
}
