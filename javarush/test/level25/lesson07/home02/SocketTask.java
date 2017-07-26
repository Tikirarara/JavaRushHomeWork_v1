package com.javarush.test.level25.lesson07.home02;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T>
{
    private Socket socket;

    protected synchronized void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    public synchronized void cancel()
    {
        //close all resources here
        try
        {
            socket.close();
        }
        catch (IOException ignored)
        {
        }
    }

    public RunnableFuture<T> newTask()
    {
        return new FutureTask<T>(this)
        {
            public boolean cancel(boolean mayInterruptIfRunning)
            {
                //close all resources here by using proper SocketTask method
                try
                {
                    socket.close();
                }
                catch (IOException ignored)
                {
                }
                //call super-class method in finally block
                finally
                {
                    super.cancel(mayInterruptIfRunning);
                }
                return true;
            }
        };
    }
}