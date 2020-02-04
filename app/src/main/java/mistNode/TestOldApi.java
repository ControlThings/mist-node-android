/**
 * Copyright (C) 2020, ControlThings Oy Ab
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * @license Apache-2.0
 */
package mistNode;

import android.util.Log;

import java.util.List;

import wish.request.Identity;

/**
 * Created by jeppe on 10/27/17.
 */

public class TestOldApi {

    private static final String TAG = "old TEST";

    public void test(){

        Identity.list(new Identity.ListCb() {
            @Override
            public void cb(List<wish.Identity> identities) {
                for (wish.Identity ide : identities) {
                    Log.d(TAG, "list: " + ide.getAlias());
                }
            }

            @Override
            public void err(int code, String msg) {}

            @Override
            public void end() {}
        });

/*
        BasicOutputBuffer buffer = new BasicOutputBuffer();
        BsonWriter writer = new BsonBinaryWriter(buffer);
        writer.writeStartDocument();
        writer.writeString("op", "listPeers");
        writer.writeStartArray("args");
        writer.writeEndArray();
        writer.writeInt32("id", 0);
        writer.writeEndDocument();
        writer.flush();

        mistNode.MistNode.getInstance().wishRequest(buffer.toByteArray(), new mistNode.MistNode.RequestCb() {
            @Override
            public void response(byte[] data) {
                Log.d(TAG, "res");
            }

            @Override
            public void end() {

            }

            @Override
            public void err(int code, String msg) {
                Log.d(TAG, "err");
            }
        });

*/
    }
}
