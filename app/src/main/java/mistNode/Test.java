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

import wish.request.Identity;

/**
 * Created by jeppe on 10/24/17.
 */

public class Test {

    static final String TAG = "testing";

    public void run() {




        Log.d(TAG, "ss1");
        Identity.create("tester", new Identity.CreateCb() {
            wish.Identity tester;

            @Override
            public void cb(wish.Identity identity) {
                tester = identity;
                Log.d(TAG, "ss2");
                Identity.export(identity.getUid(), new Identity.ExportCb() {
                    byte[] test;

                    @Override
                    public void cb(byte[] bsonData, byte[] bsonRaw) {
                        test = bsonData;
                        Identity.remove(tester.getUid(), new Identity.RemoveCb() {
                            @Override
                            public void cb(boolean value) {

                                Identity._import(test, new Identity.ImportCb() {
                                    @Override
                                    public void cb(String name, byte[] uid) {
                                        Log.d(TAG, " imported: " + name);
                                    }

                                    @Override
                                    public void err(int code, String msg) {
                                        super.err(code, msg);

                                        Log.d(TAG, " : " + msg);

                                    }
                                });
                            }
                        });

                    }
                });

            }
        });


    }


}
