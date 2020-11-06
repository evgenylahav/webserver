.. Prism documentation master file, created by
   sphinx-quickstart on Sun Jul 26 11:44:19 2020.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

.. image:: images/prism.png
   :height: 200
   :align: center

=============================================
Prism - Distributed Tasks Execution Framework
=============================================
Prism is a comprehensive framework for authoring, managing, and executing a compute intensive tasks.

Code your task by implementing a simple interface and make it ready for execution by hosting it in one of prism executor processes. You can now use one of Prism clients to submit your task and
get it's result.

Go further and use Prism to add advanced debug capabilities to your task, unittest it and its internals, extend it with C/C++/Matlab code and much more!

Distributed
===========
Prism is a distributed framework - that means you can run multiple Prism executors processes on multiple host machines, scaling out your task being able to serve higher demands.
Scheduling and distribution of tasks is handled by Prism so you can keep your focus on task implementation only.

Prism is Python Based
=====================
Prism choosed `python <https://www.python.org/>`_ as its main programming language. We believe python is one of the most productive languages out there, with great scientific libraries eco-system.
With packages like `numpy <https://numpy.org/>`_, `scipy <https://www.scipy.org/>`_, `opencv <https://opencv.org/>`_, `scikit-learn <https://scikit-learn.org/stable/>`_, `tensorflow <https://www.tensorflow.org/>`_ and more you can implement computer vision and machine learning algorithms faster (in compare to other programming languages).

Plugable and Isolated
=====================
Prism deployment model gives you the freedom to decide where your task will be hosted. Since tasks are plugable into Prism executors, you can completely isolate your task in its own process (thus dramtically reducing the `dependency hell <https://en.wikipedia.org/wiki/Dependency_hell>`_ problem) or host it with other domain related tasks (thus accepting dependecy tree alignment of all tasks).

Hetrogenous Task Implementation
===============================
Python is great but some tasks still require further optimizations that python can't provide out of the box. Prism provides a solid model for optimizations using C/C++ - you can implement parts of your task in `C/C++ <https://en.cppreference.com/w/>`_ and Prism will assist with all required data marshalling, Intel IPP integration, concurrency, etc.
Moreover, Prism supports invoking `Matlab <https://www.mathworks.com/products/matlab.html>`_ code in case you need to interop with some existing code.

Cross Platform
==============
Prism runs nativly on Windows / Linux OS. As long as your task implemention is OS agnostic, you can also execute your task on both OSs.

AMAT Tool Integration
=====================
Need to read parameters from recipe? get runtime inputs from DDS? log directly to MC main log? - Prism is bundled with a set of facades and methodolodgies for this.

.. toctree::
   :caption: User Guide
   :maxdepth: 2

   quickstart.rst
   prism_task_impl_best_practices.rst
   debugging.rst
   unittest.rst
   monitoring.rst
   cpp_interop.rst
   matlab_interop.rst

.. toctree::
   :caption: API Reference
   :maxdepth: 2

   api_reference.rst


Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`