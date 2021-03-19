package milosz.spring01;

import milosz.spring01.model.Beehive;
import milosz.spring01.model.BeehiveType;
import milosz.spring01.model.BeehiveMark;
import milosz.spring01.service.BeehiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public  class DataLoader implements CommandLineRunner {

    @Autowired
    BeehiveService beehiveService;

    @Override
    public void run(String... args) throws Exception {
        Beehive beehive1=new Beehive(
                "1",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,9,4),
                LocalDate.of(2017,6,1),
                BeehiveMark.GOOD,
                true);

        Beehive beehive2=new Beehive(
                "22",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,9,2),
                LocalDate.of(2017,6,1),
                BeehiveMark.GOOD,
                true);

        Beehive beehive3=new Beehive(
                "12",
                BeehiveType.WOOD,
                LocalDate.of(2020,10,11),
                LocalDate.of(2014,5,1),
                BeehiveMark.BAD,
                true);
        Beehive beehive4=new Beehive(
                "15",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2019,9,17),
                LocalDate.of(2015,6,12),
                BeehiveMark.GOOD,
                false);
        Beehive beehive5=new Beehive(
                "23",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,10,27),
                LocalDate.of(2013,7,23),
                BeehiveMark.EXCELENT,
                true);
        Beehive beehive6=new Beehive(
                "51",
                BeehiveType.WOOD,
                LocalDate.of(2019,8,1),
                LocalDate.of(2015,5,31),
                BeehiveMark.BAD,
                false);

        Beehive beehive7=new Beehive(
                "42",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,9,16),
                LocalDate.of(2016,5,21),
                BeehiveMark.BAD,
                false);

        Beehive beehive8=new Beehive(
                "55",
                BeehiveType.WOOD,
                LocalDate.of(2021,3,15),
                LocalDate.of(2012,8,18),
                BeehiveMark.BAD,
                false);

        Beehive beehive9=new Beehive(
                "84",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,10,1),
                LocalDate.of(2011,5,31),
                BeehiveMark.BAD,
                false);

        Beehive beehive10=new Beehive(
                "38",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2020,10,2),
                LocalDate.of(2013,5,31),
                BeehiveMark.BAD,
                false);

        Beehive beehive11=new Beehive(
                "75",
                BeehiveType.WOOD,
                LocalDate.of(2019,8,1),
                LocalDate.of(2013,5,31),
                BeehiveMark.BAD,
                false);

        Beehive beehive12=new Beehive(
                "66",
                BeehiveType.POLYURETHAN,
                LocalDate.of(2019,8,1),
                LocalDate.of(2013,5,31),
                BeehiveMark.BAD,
                false);

        Beehive beehive13=new Beehive(
                "67",
                BeehiveType.WOOD,
                LocalDate.of(2020,9,30),
                LocalDate.of(2013,8,31),
                BeehiveMark.BAD,
                false);

        beehiveService.addBeehive(beehive1);
        beehiveService.addBeehive(beehive2);
        beehiveService.addBeehive(beehive3);
        beehiveService.addBeehive(beehive4);
        beehiveService.addBeehive(beehive5);
        beehiveService.addBeehive(beehive6);
        beehiveService.addBeehive(beehive7);
        beehiveService.addBeehive(beehive8);
        beehiveService.addBeehive(beehive9);
        beehiveService.addBeehive(beehive10);
        beehiveService.addBeehive(beehive11);
        beehiveService.addBeehive(beehive12);
        beehiveService.addBeehive(beehive13);

    }
}
