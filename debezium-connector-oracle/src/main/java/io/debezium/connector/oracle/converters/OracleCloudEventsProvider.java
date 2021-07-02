/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.oracle.converters;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;

import io.debezium.connector.oracle.Module;
import io.debezium.converters.CloudEventsMaker;
import io.debezium.converters.CloudEventsProvider;
import io.debezium.converters.RecordParser;
import io.debezium.converters.SerializerType;

/**
 * An implementation of {@link CloudEventsProvider} for Oracle.
 *
 * @author Chris Cranford
 */
public class OracleCloudEventsProvider implements CloudEventsProvider {
    @Override
    public String getName() {
        return Module.name();
    }

    @Override
    public RecordParser createParser(Schema schema, Struct record) {
        return new OracleRecordParser(schema, record);
    }

    @Override
    public CloudEventsMaker createMaker(RecordParser parser, SerializerType contentType, String dataSchemaUriBase) {
        return new OracleCloudEventsMaker(parser, contentType, dataSchemaUriBase);
    }
}
