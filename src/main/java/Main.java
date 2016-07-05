import com.veinteractive.dataReceivers.ProcessedMessages.SessionDto;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.thrift.ThriftData;
import org.apache.avro.thrift.ThriftDatumWriter;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ThriftDatumWriter<SessionDto> thWriter = new ThriftDatumWriter<SessionDto>(SessionDto.class);
        DataFileWriter<SessionDto> dataFileWriter = new DataFileWriter<SessionDto>(thWriter);
        Schema schema= ThriftData.get().getSchema(SessionDto.class);
        dataFileWriter.create(schema,new File("session.avro"));
        dataFileWriter.close();
    }
 }