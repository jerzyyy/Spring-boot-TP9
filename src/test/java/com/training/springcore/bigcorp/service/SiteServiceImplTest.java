package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Measure;
import com.training.springcore.bigcorp.model.MeasureStep;
import com.training.springcore.bigcorp.service.measure.FixedMeasureService;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class SiteServiceImplTest {
        @Configuration
        @ComponentScan("com.training.spring.bigcorp.service")
        static class SiteServiceTestConfiguration{ }
        @Autowired
        private SiteService siteService;
        @Rule
        public OutputCapture output = new OutputCapture();
        //@Test
       /* public void readFileFromUrl(){
            siteService.readFile("file:///C:/lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        }
        @Test
        public void readFileFromClasspath(){
        siteService.readFile("classpath:lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        }
        @Test
        public void readFileFromFileSystem(){
        }*/
    private FixedMeasureService service;
    /**
     * Captor used in tests
     */
    private Captor captor = new Captor("test");
    /**
     * Start instant used in tests
     */
    Instant start = Instant.parse("2018-09-01T22:00:00Z");
    /**
     * End instant used in tests. We define a one day period
     */
    Instant end = start.plusSeconds(60 * 60 * 24);




    @Test
    public void readMeasuresThrowsExceptionWhenArgIsNull(){
        assertThatThrownBy(() -> service.readMeasures(null, start, end, MeasureStep.ONE_DAY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("captor is required");
        assertThatThrownBy(() -> service.readMeasures(captor, null, end, MeasureStep.ONE_DAY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("start is required");
        assertThatThrownBy(() -> service.readMeasures(captor, start, null, MeasureStep.ONE_DAY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("end is required");
        assertThatThrownBy(() -> service.readMeasures(captor, start, end, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("step is required");
        assertThatThrownBy(() -> service.readMeasures(captor, end, start, MeasureStep.ONE_DAY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("start must be before end");
    }
    @Test
    public void readMeasures(){
        List<Measure> measures = service.readMeasures(captor, start, end, MeasureStep.ONE_HOUR);
// We should have 24 values one for each hour
        assertThat(measures).hasSize(24);
// For the moment we have always the same value
        assertThat(measures).extracting(Measure::getValueInWatt).contains(10_000_000);
// And we have a value for each hour of the period
        assertThat(measures)
                .extracting(Measure::getInstant)
                .extracting(Instant::toString)
                .containsExactly(
                        "2018-09-01T22:00:00Z",
                        "2018-09-01T23:00:00Z",
                        "2018-09-02T00:00:00Z",
                        "2018-09-02T01:00:00Z",



                        "2018-09-02T02:00:00Z",
                        "2018-09-02T03:00:00Z",
                        "2018-09-02T04:00:00Z",
                        "2018-09-02T05:00:00Z",
                        "2018-09-02T06:00:00Z",
                        "2018-09-02T07:00:00Z",
                        "2018-09-02T08:00:00Z",
                        "2018-09-02T09:00:00Z",
                        "2018-09-02T10:00:00Z",
                        "2018-09-02T11:00:00Z",
                        "2018-09-02T12:00:00Z",
                        "2018-09-02T13:00:00Z",
                        "2018-09-02T14:00:00Z",
                        "2018-09-02T15:00:00Z",
                        "2018-09-02T16:00:00Z",
                        "2018-09-02T17:00:00Z",
                        "2018-09-02T18:00:00Z",
                        "2018-09-02T19:00:00Z",
                        "2018-09-02T20:00:00Z",
                        "2018-09-02T21:00:00Z");
    }

    }
