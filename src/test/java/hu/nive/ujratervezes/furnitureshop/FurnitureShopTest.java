package hu.nive.ujratervezes.furnitureshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FurnitureShopTest {

    private Bed createTwinBedOne() {
        return new TwinBed(23000, new SingleMattress(13000));
    }

    private Bed createTwinBedTwo() {
        return new TwinBed(31000, new SingleMattress(17000));
    }

    private Bed createKingBedThree() {
        return new KingBed(53000, new SingleMattress(17000), new SingleMattress(17000));
    }

    private Bed createKingBedFour() {
        return new KingBed(57000, new DoubleMattress(39000));
    }

    private Bed createKingBedFive() {
        return new KingBed(53000, new DoubleMattress(47000));
    }

    private Mattress createSingleMattress() {
        return new SingleMattress(1234);
    }

    private Mattress createDoubleMattress() {
        return new DoubleMattress(1234);
    }

    private List<Bed> createBeds() {
        return new ArrayList<>() {{
            add(createTwinBedOne());
            add(createTwinBedTwo());
            add(createKingBedThree());
            add(createKingBedFour());
            add(createKingBedFive());
        }};
    }

    @Test
    void getProductList() {
        List<Bed> beds = createBeds();
        FurnitureShop furnitureShop = new FurnitureShop();
        beds.forEach(furnitureShop::addNewBed);
        assertEquals(beds, furnitureShop.getBedList());
    }

    @Test
    void test_countAvailableBeds() {
        List<Bed> beds = createBeds();
        FurnitureShop furnitureShop = new FurnitureShop();
        beds.forEach(furnitureShop::addNewBed);
        assertEquals(beds.size(), furnitureShop.countAvailableBeds());
    }

    @Test
    void test_addBed() {
        FurnitureShop furnitureShop = new FurnitureShop();
        Bed bed = createTwinBedOne();
        furnitureShop.addNewBed(bed);
        assertTrue(furnitureShop.getBedList().contains(bed));
    }

    @Test
    void test_removeBed() {
        Bed bedOne = createTwinBedOne();
        Bed bedTwo = createTwinBedTwo();
        Bed bedThree = createKingBedThree();
        List<Bed> expectedBeds = new ArrayList<>() {{
            add(bedOne);
            add(bedThree);
        }};
        FurnitureShop furnitureShop = new FurnitureShop();
        furnitureShop.addNewBed(bedOne);
        furnitureShop.addNewBed(bedTwo);
        furnitureShop.addNewBed(bedThree);
        furnitureShop.removeBed(bedTwo);
        assertEquals(expectedBeds, furnitureShop.getBedList());
    }

    @Test
    void test_calculateAveragePriceOfBeds() {
        Bed bedOne = createTwinBedOne();
        Bed bedTwo = createTwinBedTwo();
        Bed bedThree = createKingBedThree();
        List<Bed> beds = new ArrayList<>() {{
            add(bedOne);
            add(bedTwo);
            add(bedThree);
        }};
        FurnitureShop furnitureShop = new FurnitureShop();
        beds.forEach(furnitureShop::addNewBed);
        assertEquals(57000.0, furnitureShop.calculateAveragePriceOfBeds());
    }

    @Test
    void getMattressPrice() {
        Mattress mattress = new SingleMattress(15000);
        assertEquals(15000, mattress.getPrice());
    }

    @Test
    void test_getBedTypeTwin() {
        Bed bed = createTwinBedOne();
        assertEquals(BedType.TWIN, bed.getType());
    }

    @Test
    void test_getBedTypeKing() {
        Bed bed = createKingBedFour();
        assertEquals(BedType.KING, bed.getType());
    }

    @Test
    void test_getMattress() {
        SingleMattress mattress = new SingleMattress(12000);
        List<Mattress> mattressList = new ArrayList<>() {{
            add(mattress);
        }};
        Bed bed = new TwinBed(1000, mattress);
        assertEquals(mattressList, bed.getMattressList());
    }

    @Test
    void test_calculateBedFramePrice() {
        Bed bed = createTwinBedTwo();
        assertEquals(31000, bed.getBedFramePrice());
    }

    @Test
    void test_calculatePrice() {
        Bed bed = createTwinBedTwo();
        assertEquals(48000d, bed.getPrice());
    }

    @Test
    void test_numberOfMattress() {
        Bed bed = createKingBedThree();
        assertEquals(87000d, bed.getPrice());
    }

    @Test
    void test_bedIsTwin() {
        Bed bed = createTwinBedOne();
        assertTrue(bed instanceof TwinBed);
    }

    @Test
    void test_bedIsKing() {
        Bed bed = createKingBedThree();
        assertTrue(bed instanceof KingBed);
    }

    @Test
    void test_mattressIsSingle() {
        Mattress mattress = createSingleMattress();
        assertTrue(mattress instanceof SingleMattress);
    }

    @Test
    void test_mattressIsDouble() {
        Mattress mattress = createDoubleMattress();
        assertTrue(mattress instanceof DoubleMattress);
    }

    @Test
    void test_getPrice() {
        Bed bed = createTwinBedOne();
        assertEquals(36000d, bed.getPrice());
    }

    @Test
    void test_getBedFramePrice() {
        Bed bed = createTwinBedOne();
        assertEquals(23000, bed.getBedFramePrice());
    }

    @Test
    void getListOfBedsByTypeTwin() {
        Bed bed = new TwinBed(23145, new SingleMattress(324));
        FurnitureShop furnitureShop = new FurnitureShop();
        furnitureShop.addNewBed(bed);
        List<Bed> expectedList = new ArrayList<>();
        expectedList.add(bed);
        assertEquals(expectedList, furnitureShop.getListOfBedsByType(BedType.TWIN));
    }

    @Test
    void getListOfBedsByTypeKing() {
        Bed bedTwin1 = new TwinBed(2300, new SingleMattress(2300));
        Bed bedTwin2 = new TwinBed(2000, new SingleMattress(2000));
        Bed bed = new KingBed(23000, new SingleMattress(3200), new SingleMattress(2000));
        FurnitureShop furnitureShop = new FurnitureShop();
        furnitureShop.addNewBed(bedTwin2);
        furnitureShop.addNewBed(bedTwin1);
        furnitureShop.addNewBed(bed);
        furnitureShop.getListOfBedsByType(BedType.KING);
        List<Bed> expectedList = new ArrayList<>();
        expectedList.add(bed);
        assertEquals(expectedList, furnitureShop.getListOfBedsByType(BedType.KING));
    }

    @Test
    void test_getWidthTwinType() {
        Bed bedTwin1 = new TwinBed(23000, new SingleMattress(2000));
        assertEquals(90, bedTwin1.getType().getWidth());
    }

    @Test
    void test_getWidthKingType() {
        Bed bedKing = new KingBed(23000, new DoubleMattress(2000));
        assertEquals(180, bedKing.getType().getWidth());
    }

    @Test
    void test_getWidthSingleMattress() {
        Mattress singleMattress = new SingleMattress(23000);
        assertEquals(90, singleMattress.getWidth());
    }

    @Test
    void test_getWidthDoubleMattress() {
        Mattress doubleMattress = new DoubleMattress(23000);
        assertEquals(180, doubleMattress.getWidth());
    }
}